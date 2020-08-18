package cn.iocoder.springboot.lab01.clonetest.vo;

import lombok.Data;

import java.util.Map;

@Data
public class UserVO {
    private Integer id;
    private String username;
    private UserVO2 userVO2;
    private Map map;
}
