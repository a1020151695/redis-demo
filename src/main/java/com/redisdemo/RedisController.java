package com.redisdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Cola
 * @description
 * @date 2022/1/10
 * @email 1020151695@qq.com
 */
@RestController
public class RedisController {
    @Resource
    RedisService redisService;

    /**
    * @author cola
    * @description 登录且初始化count
    * @date 2022/1/10
    * @email 1020151695@qq.com
    */
    @RequestMapping("/name")
    public String getName(){
        redisService.setString("name","cola");
        redisService.setString("count","0");
        return redisService.getString("name");
    }

    /**
    * @author cola
    * @description count计数
    * @date 2022/1/10
    * @email 1020151695@qq.com
    */
    @RequestMapping("/count")
    public Integer getCount(){
        String countString = redisService.getString("count");
        if(countString == null)return null;
        Integer count = Integer.parseInt(countString);
        count++;
        // 设置了10s的有效期
        redisService.setString("count",count.toString());
        return count;
    }


}
