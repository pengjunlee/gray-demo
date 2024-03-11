package gray.demo.adapter.controller;

import gray.demo.api.service.BaseUserService;
import gray.demo.common.entity.BaseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author 二月菌
 * @since 2024-03-11 17:05:37
 */
@RestController
@RequestMapping("/baseUser")
@RequiredArgsConstructor
public class BaseUserController {

    private final BaseUserService baseUserService;

    @RequestMapping("/{id}")
    public BaseUser getById(@PathVariable(name = "id") Long id) {
        return baseUserService.getById(id);
    }

}
