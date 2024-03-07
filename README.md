# grayApplication

## 介绍
grayApplication

## 软件架构
- starter 里面只有一个启动类
- adapter 对外能力统一入口适配器
- common 全局公用类定义：枚举、工具类、常量等
- factory 领域对象实体、数据库对象实体之间转换工厂定义
- service 服务定义
- implement 服务Service实现类，不处理业务，只做编排
- infrastructure 基础设施层


## 使用说明

### 校验逻辑规范：
- adapter层 复杂参数是否合法的校验
- service层 负责业务流程异常或流程中断、流程分支等必要的判断
- domain层 负责产品经理提出的要求的业务规则的校验。


### 实体转换规范
1实体和值对象属于domain domain中只能看到实体和值对象 看不见context中的所有dto po。
2由外部参数来新建实体，在factory中实现，app层调用，
3由外部对象来转化成领域中使用的值对象也在factory中 实现，app层调用。
4由数据库层或者第三方返回的技术设施层对象如PO等 转换成实体或者值对象也是在factory中完成， 由infrastructure层完成转换而不是app层。


逻辑规则：
app层的service负责业务逻辑技术上的编排（先干什么后干什么）
domain层负责 业务逻辑的真正实现，各种产品输出的业务规则的实现。

领域对象规范：


实体：  实体所有的属性只有getter方法 禁止提供setter方法


实体： 实体所有的构造函数都只能是protected  或者使用注解实现全参protected构造函数， @AllArgsConstructor(access = AccessLevel.PACKAGE)


实体的构造函数 只能由对应的factory来使用，其他地方不能使用实体的构造函数。


实体暴露给外部的public方法一定是要根据业务场景对象能力来定的 而不是根据字段来定的。有多少各能力有多少方法


值对象： 值对象所有字段都必须加上final


值对象构造函数任何层都可以使用 ，也可以选择使用factory构造。


值对象可以有public方法提供业务逻辑。


聚合：
A实体中包含B实体时候，是否一定要通过A实体去操作B实体 不一定。要看AB实体是否形成一个A聚合。需要灵活运用。


repo：
repo的定义一定要分场景，为每个业务用例场景提供repo中的方法，不要多场景共用repo
非常不建议定义参数自动更新字段这种通用的repo函数（适应性太强的repo都不建议）。



infrastructure层规范
所有的技术实现都在这里 ，但是其调用方式app层 app层无法直接访问这一层，所以其接口都定义在domain-core层

其他规范：

事务：
//方案1 ：应用服务这里可以做事务控制,还有领域服务也可以做事务控制  不推荐
//方案2 ： 事务一定在领域服务做做控制， 这个地方 appservice不做事务控制   暂定方案2
消息订阅：
在adapter层订阅外部消息
外部定时器：
触发handle在adapter层实现
消息推送：
在infrastructure层实现


清分代码评审记录20221105
代码评审记录

代码之道：好的代码其中一个重要的标准是可读性好

DDD的代码实践其中一个指导性原则，代码的可读性要好具有高优先级。


Java规范，代码习惯


注释使用javaDoc注释标准，具体标准参考王亚南的easyyapi分享。


非显而易见的硬编码|魔法值,需要实现为常量或者枚举。 提升可读性



命名规范：

类和方法的的命名风格为：类名采用名词，方法采用动词

错误示例


TempRequireVersionAddService.recive()
TempRequireVersionModifyService.recive()



正确示例


TempRequireVersionService.add()
TempRequireVersionService.modify()



对象和和变量命名要易懂，要和领域语言一致

错误示例：


void excute(Event headEvent){
// do something
}



正确示例


void excute(Event OrderCreatedEvent){
//do something
}



Factory中的方法命名规范，尽量和实际作用一致，和面向对象的思维一致。不要按面向结构的思维命名
creat这个词更多的是指创建,是动作。一般来说十否收拢业务逻辑不明确。
而build含义更多的是构建。 一般来说是通过Dto等外部对象构建领域对象，有逻辑收口的含义。
相对而言 build更满足我们整个框架的思路。采用这个词 会比较容易让我代码编写和阅读思路更自然。

错误示例：


TempRequireMainlineVersionFactory.creatXXX();



正确示例


TempRequireMainlineVersionFactory.buildXXX();



类名根据模型走，根据模型设计走，改变从数据库编程的习惯。不要根据数据库设计编码。根据表名字段名定义类名属性名


Factory和 repo 的个数是和模型相关的，与《DDD聚合》 的个数一致。每个模型中的聚合对应一个Factory，而不是每张表相关的Po对象对应一个Factory


build是左边 通过外部进来的dto对象构建领域对象


rebuild是从右边  数据库，第三方等外部地方重构领域对象


repo二个职责：  rebuild 和持久化领域对象


factory二个职责：   build对象  和 帮助《repo》rebuild领域对象


错误示例：



Class TempRequireMainlineVersionFactory{}

//这个方法的语义不是查询  是rebuild  命名要改
tempRequireDistributeRepo.selectByRequireIdAndStatus(Long id,int status) {}




正确示例


Class TempRequireVersionFactory{}
tempRequireDistributeRepo.rebuildTempRequireDistribute(Long id,int status) {}




逻辑位置规范


总原则：调用在app  定义在domain  实现在infrastructure。


所有与外部交互的逻辑调用都是在app层，实现都是在infrastructure


APP调APP的内部service接口定义直接放在app-impl模块


domain层vo对象不允许叫QueryRsp这种DTO命名法


sao 规范 方案1：返回的结果应该定义在context模块，再转换成domain的Vo。方案2：容忍sao返回的结果直接使用domain的Vo，


sao的2个方案的具体使用要根据真实情况而定，如果需要防腐 就多转换一次。很确定不需要防腐就一次性直接到位， Sao的签名直接使用领域层的Vo。


DService domain层的Service 也就是领域服务 不需要接口， 实现不能放在infrastructure（没有接口当然没有实现）


APP层不要有私有方法，当逻辑很长时要审视某些逻辑是否应该在其他层，而不是抽私有方法



复杂对象的保存


复杂对象的保存   一个领域对象有多个子对象 对应多个PO时


原则：领域对象的操作和 领域对象的持久化操作需要进行分离。


所以在domain层领域对象操作的时候 部分对象id可以为null. 导航使用对象导航而非id导航关系。


在infrastructure层持久化的时候  PO的id可以从上一个持久化的PO中获取id。


方案1： 在repo中多个PO保存时，每个PO保存成功后 调用entity提供的 resetEntity的Id方法，实体本身提供表示持久化后 数据库生成的id回写到实体能力



设计模式
每种资源的询问和应答都要分开，满足开闭原则，共同逻辑放在抽象类

约束


domain层的对象不能new，并且不能setter 只能用factory或repo构建，不能有@Builder这种


Vo的构建约束是否放开待讨论。 Vo是否严格按照final来执行。 至少有防腐层的Vo是应该final的 其中的集合是不可修改的


状态要用枚举赋值



清分代码评审记录20221114
rebuild 用法不合理：
query这个词 用法不合理:
List tempRequireDistributeList = tempRequireDistributeRepo.queryToPack(i * limit, limit);
TempRequireDistributePackageRelation relation = TempRequireDistributePackageRelationFactory.INSTANCE.rebuild(tempRequireDistributePackage);

车后模型评审记录&资源模型评审记录20221122。


1建模整体思路问题
流程图设计和做DDD之前有什么差异？是没有区别的，说明这个设计本质还是流程式的分析，流程式的建模 。
业务在人大脑中的映射仍然是流程式的结构式的。


2没有必要先流程建模再对象建模。


3流程建模的结果是易变的。几个版本后 流程即不适用了，而对象建模很可能是少量变化。
对象建模更稳定，建模是要花时间 花代价的。所以如果没有长期受益是不划算的。


4什么叫抽象：抽象就是关注点分离。


5模型之间的线可以有多条，表达不同的场景上的不同关系，  线上可以有文字说明


6<> 的表达简化一下。


7图上应该表达的对象本身的能力 而不是对象有关的逻辑。 对象相关的逻辑不仅仅有领域逻辑，还有应用逻辑。
思考  批量操作一批对象这个动作。这算什么??属于哪个对象？？


8 对象的动作 不能抽象成‘修改’这样的动作，修改本身是面向过程的， 要根据修改的场景。找到修改的理由。确定这个场景修改的逻辑。动作命名要根据场景来，找到合适的名字，找到真正的理由



航空代码评审记录 20221123
1、明确sao中多层调用的实现的规则；
2、针对 模型中对应需要额外参数 辅助验证的时候(可能存在多余的查询)，如何解决 fail-fast ;
3、app层的描述更多的是实现业务流程，类似脚本化的方式。
4、领域，领域聚合的定义，应该有明确的标准和规范，使得模型边界更加清晰；
6、对于多表查询的时候，建议的方式 还是采用流程化编程的方式。
7、Vo不应该定义在context中，已经修改相关的文档
8、领域模型中，允许有动态的规则，如动态字段适配生成更新方法，查询方法等；
9、不影响领域模型业务的其他纯粹的技术手段是可以被使用的；
10、分页建议方式 将ipage 分离出来单独的jar

交易代码规范理解评审记录20221129

评审前问题：
分页的定义， 内部封装还是透传mybatis的； 从DDD考虑， 自己封装；
所有与外部交互的逻辑调用都是在app层，实现都是在infrastructure  → 外部是指哪些？
状态要用枚举赋值  → PO也是吗？
由外部参数来新建实体，在factory中实现，app层调用  → 为什么不是各层自己转换
实体和值对象属于domain domain中只能看到实体和值对象 看不见context中的所有dto po ?  目前是能看到的吧 是否完全严格？ XXO只在相关层，不全局；
VO是指啥？  值对象？  视图对象？ 如果是值对象，都放在entity
第三方服务是否也定义为DService， 只不过内部是sao调用；
适配层，直观来说我不适配应该不影响应用的整体功能，也就是我直接干掉是否会影响服务功能，从这个角度来说，定时器和发布订阅就不属于适配层的东西；
PO要内嵌吗？比如订单聚合根下有订单和订单日志2个实体；
仓储操作的是PO还是DO ?
controller是否可以直接调用doma