package com.hospital.medicalsystem.repository;

import com.hospital.medicalsystem.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void findAll() {
        System.out.println(personRepository.findAll());
    }

    /**
     * 用户注册-重定义接口 测试成功
     */
    @Test
    void register() {
        //注册用户并返回personId
        Person person = new Person();
        person.setName("用户名test");
        person.setPassword("密码test");
        person.setTel("电话test");
        person.setEmail("邮箱test");
        person.setUserTypes(0);
        Person responseList = personRepository.save(person);
        person.setPersonId(responseList.getPersonId());
        //装配result
        Result result = new Result();
        result.setCode(1);
        result.setMsg("登录成功");
        result.setData(person.getPersonId());
        System.out.println(result.getCode());
        System.out.println(result.getMsg());
        System.out.println(result.getData());
    }

    /**
     * 用户登录测试
     * 流程：
     * 查询是否有此personId
     * 验证personId是否与password匹配
     * 验证账密是否与userTypes匹配
     * 测试成功
     */
    @Test
    void login() {
        Integer personId = 1;
        String password = "1";
        Integer userTypes = 0;
        Result result = new Result();
        Person person;
        if (personRepository.findByPersonId(personId).isEmpty()) {
            result.setCode(-1);
            result.setMsg("该用户未注册");
        } else if (personRepository.findByPersonIdAndPassword(personId, password).isEmpty()) {
            result.setCode(-2);
            result.setMsg("该用户密码错误");
        } else if (personRepository.findByPersonIdAndPasswordAndUserTypes(personId, password, userTypes).isEmpty()) {
            result.setCode(-3);
            result.setMsg("该用户身份错误");
        } else {
            person = personRepository.findByPersonId(personId).get(0);
            person.setPassword("");
            result.setCode(1);
            result.setMsg("登录成功");
            result.setData(person);
        }
        System.out.println(result.getCode());
        System.out.println(result.getMsg());
        System.out.println(result.getData());
    }
}