package cn.iocoder.springboot.lab01.clonetest.controller;

import cn.iocoder.springboot.lab01.clonetest.vo.UserVO;
import cn.iocoder.springboot.lab01.clonetest.vo.UserVO2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clone")
public class CloneController {

    @GetMapping("/demo")
    public String demo() {
        return "示例返回";
    }

    public static void main(String[] args) {
        deepClone(); //深克隆
        simpleClone(); //浅克隆
    }

    /**
     * 深克隆
     */
    public static void deepClone() {
        UserVO uv = new UserVO();
        uv.setId(123);
        uv.setUsername("fudayu");
        UserVO2 uv2 = new UserVO2();
        uv2.setId(456);
        uv2.setUsername("jjl");
        Map map = new HashMap();
        map.put("aaa", "111");
        map.put("bbb", "222");
        uv.setUserVO2(uv2);
        uv.setMap(map);
        System.out.println("***********************************深克隆*************************************************");
        System.out.println("操作前的数据：" + uv
                + "数据：" + uv.getUserVO2().getUsername()
                + "map：" + uv.getMap()
                + "value：" + uv.getMap().get("aaa"));
//        UserVO uvAfter = new UserVO();
//        BeanUtils.copyProperties(uv, uvAfter);
        String uvjson = com.alibaba.fastjson.JSON.toJSONString(uv);
        UserVO uvAfter = com.alibaba.fastjson.JSON.parseObject(uvjson, UserVO.class);
        uv2.setUsername("jiangjinglian");
        map.put("aaa", "555");
        System.out.println("操作后的数据:" + uvAfter
                + "深克隆数据:" + uvAfter.getUserVO2().getUsername()
                + "深克隆map:" + uvAfter.getMap()
                + "深克隆value:" + uvAfter.getMap().get("aaa"));
        System.out.println("操作后的数据:" + uv
                + "更改的数据:" + uv.getUserVO2().getUsername()
                + "更改的map:" + uv.getMap()
                + "更改的value:" + uv.getMap().get("aaa"));
    }

    /**
     * 浅克隆
     */
    public static void simpleClone() {
        UserVO uv = new UserVO();
        uv.setId(123);
        uv.setUsername("fudayu");
        UserVO2 uv2 = new UserVO2();
        uv2.setId(456);
        uv2.setUsername("jjl");
        Map map = new HashMap();
        map.put("aaa", "111");
        map.put("bbb", "222");
        uv.setUserVO2(uv2);
        uv.setMap(map);
        System.out.println("***********************************浅克隆*************************************************");
        System.out.println("操作前的数据：" + uv
                + "数据：" + uv.getUserVO2().getUsername()
                + "map：" + uv.getMap()
                + "value：" + uv.getMap().get("aaa"));
        UserVO uvAfter = new UserVO();
        BeanUtils.copyProperties(uv, uvAfter);
        uv2.setUsername("jiangjinglian");
        map.put("aaa", "555");
        System.out.println("操作后的数据:" + uvAfter
                + "深克隆数据:" + uvAfter.getUserVO2().getUsername()
                + "深克隆map:" + uvAfter.getMap()
                + "深克隆value:" + uvAfter.getMap().get("aaa"));
        System.out.println("操作后的数据:" + uv
                + "更改的数据:" + uv.getUserVO2().getUsername()
                + "更改的map:" + uv.getMap()
                + "更改的value:" + uv.getMap().get("aaa"));
    }
}
