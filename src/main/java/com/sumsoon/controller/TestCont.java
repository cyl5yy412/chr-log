package com.sumsoon.controller;

import com.sumsoon.zzz.mapper.OthMapper;
import com.sumsoon.zzz.mapper.XXXMapper;
import com.sumsoon.zzz.po.XXX;
import com.sumsoon.zzz.po.XXXExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Chr on 2019/5/13.
 */

@Slf4j
@RestController
@RequestMapping(value = "/te")
public class TestCont {


    @Autowired
    private XXXMapper xxxMapper;
    @Resource
    private OthMapper othMapper;

    @RequestMapping(value = "/st0")
    public String show0() {


        return "suc";
    }

    @RequestMapping(value = "/st")
    public String show() {

        xxxMapper.insertSelective(new XXX("127", "345", "456", "987"));
        xxxMapper.insertSelective(new XXX("128", "345", "456", "987"));
        xxxMapper.insertSelective(new XXX("129", "345", "456", "987"));

        return "suc";
    }

    @RequestMapping("/st1")
    public Object show1() {
        List<XXX> xxxes = othMapper.query0("12");

        return xxxes;
    }

    //mybatis-generator:的模糊查询
    @RequestMapping("/st2")
    public Object show2() {
        XXXExample example = new XXXExample();
        XXXExample.Criteria criteria = example.createCriteria();
//        criteria.andMaaLike("123");
        criteria.andMaaLike("12" + "%");

        List<XXX> xxxes = xxxMapper.selectByExample(example);

        return xxxes;
    }

    @RequestMapping("/st3")
    public Object show3() {

        List<Map<String, Object>> maps = othMapper.query1("12");
        return maps;

    }

    @RequestMapping("/st4")
    public Object show4() {

        Map<String, String> map = new HashMap<>();
        map.put("maa", "12");

        List<Map<String, Object>> maps = othMapper.query2(map);
        return maps;

    }

    @RequestMapping("/st5")
    public Object show5() {

        List<Map<String, Object>> maps = othMapper.query3(new XXX("12", "", "", ""));

        return maps;

    }

    @RequestMapping("/st6")
    public Object show6() {
        List<Map<String, Object>> maps = othMapper.query4("12");

        return maps;

    }

    @RequestMapping("/st7")
    public Object show7() {
        List<Map<String, Object>> maps = othMapper.query5("12");

        return maps;

    }

    @RequestMapping("/st77")
    public Object show77() {
        List<Map<String, Object>> maps = othMapper.query55("12");

        return maps;

    }

    @RequestMapping("/st8")
    public Object show8() {
        List<Map<String, Object>> maps = othMapper.query6("12");

        return maps;

    }
}
