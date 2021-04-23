INSERT INTO `medicaldb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('1', '管理员', '1', '110', '110@qq.com', '0');
INSERT INTO `medicaldb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('2', '院长', '2', '110', '110@qq.com', '1');
INSERT INTO `medicaldb`.`person` (`person_id`, `name`, `password`, `tel`, `email`, `user_types`)
VALUES ('3', '医生', '3', '110', '110@qq.com', '2');
INSERT INTO `medicaldb`.`repair_form` (`form_id`, `person_id`, `whether_public`, `item_type`, `message`, `address`, `tel`,
                                     `whether_pay`, `state_repair`, `repair_date`, `evaluation_star`, `evaluation_note`)
VALUES ('1', '1', '0', '家电', '无', '西安科技大学', '110', '1', '0', '2020-12-28', '1', '无');