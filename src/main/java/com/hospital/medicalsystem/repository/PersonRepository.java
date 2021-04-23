package com.hospital.medicalsystem.repository;

import com.hospital.medicalsystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Integer> {
    /**
     * @param personId 用户Id
     * @return 返回该用户信息
     */
    List<Person> findByPersonId(Integer personId);

    /**
     * @param personId 用户Id
     * @param password 密码
     * @return 返回该用户信息
     */
    List<Person> findByPersonIdAndPassword(Integer personId, String password);

    /**
     * @param personId 用户Id
     * @param password 密码
     * @param userTypes 用户身份
     * @return 返回该用户信息
     */
    List<Person> findByPersonIdAndPasswordAndUserTypes(Integer personId, String password, Integer userTypes);

    List<Person> findPersonByPersonId(Integer PersonId);
}
