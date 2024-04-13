package org.example.springblogjpamysql.test;

import org.example.springblogjpamysql.model.RoleType;
import org.example.springblogjpamysql.model.User;
import org.example.springblogjpamysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dummy/users")
    public List<User> user() {
        return userRepository.findAll();

    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();

        return users;
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable String id) {

//        return userRepository.findById(Integer.valueOf(id)).orElseThrow(() -> {
//            return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
//        });

        User user = userRepository.findById(Integer.valueOf(id)).orElseGet(new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        });

        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("user = " + user);
        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }

}
