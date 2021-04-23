package com.hospital.medicalsystem.controller;

import com.hospital.medicalsystem.entity.*;
import com.hospital.medicalsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonHandler {
    @Autowired
    private PersonRepository personRepository;

    /**
     * findAll测试
     */
    @GetMapping("/findAll")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * 用户注册
     *
     * @param person name/password/tel/email/userTypes: 姓名/密码/电话/邮箱/用户身份
     * @return result code:1
     * result msg:"登录成功"
     * result data:personId
     */
    @PostMapping("/register")
    public Result register(@RequestBody Person person) {
        //注册用户并返回personId
        Person responseList = personRepository.save(person);
        person.setPersonId(responseList.getPersonId());
        //装配result
        Result result = new Result();
        result.setCode(1);
        result.setMsg("注册成功");
        result.setData(person.getPersonId());
        return result;
    }

    /**
     * 用户登录
     *
     * @param person personId/password/userTypes:用户Id/密码/用户身份
     * @return result code:-1/-2/-3/0 [用户未注册：-3，密码错误：-2，用户身份错误：-3，登录成功：1]
     * result msg:用户未注册/密码错误/用户身份错误/登录成功
     * result data:person全表[password置空]
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody Person person) {

        Result result = new Result();
        if (personRepository.findByPersonId(person.getPersonId()).isEmpty()) {
            result.setCode(-1);
            result.setMsg("该用户未注册");
        } else if (personRepository.findByPersonIdAndPassword(person.getPersonId(),
                person.getPassword()).isEmpty()) {
            result.setCode(-2);
            result.setMsg("该用户密码错误");
        } else if (personRepository.findByPersonIdAndPasswordAndUserTypes(person.getPersonId(),
                person.getPassword(), person.getUserTypes()).isEmpty()) {
            result.setCode(-3);
            result.setMsg("该用户身份错误");
        } else {
            person = personRepository.findByPersonId(person.getPersonId()).get(0);
            person.setPassword("");
            result.setCode(1);
            result.setMsg("登录成功");
            result.setData(person);
        }
        return result;
    }
}
