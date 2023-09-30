package com.spront.spront.controller;

import com.alibaba.fastjson.JSON;
import com.spront.spront.dao.UserDao;
import com.spront.spront.entity.QueryInfo;
import com.spront.spront.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    /**
     * 日志打印（这个一般放在最前面）
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 查询所有的用户
     */
    @CrossOrigin
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        System.out.println(queryInfo);
        int numbers = userDao.getUserCounts("%" + queryInfo.getQuery() + "%"); //获取数目的总和
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", numbers);
        res.put("data", users);
        System.out.println("总条数" + numbers);
        String users_js = JSON.toJSONString(res);
        return users_js;
    }

    /**
     * 查看用户状态
     *
     * @param id
     * @param state
     * @return
     */
    @RequestMapping("/userState")
    public String updataUserState(@RequestParam("id") Integer id,
                                  @RequestParam("state") Boolean state) {
        int a = userDao.updateState(id, state); //获取到用户的id和state
        System.out.println("用户编号" + id);
        System.out.println("用户状态" + state);
        String str = a > 0 ? "success" : "error";
        return str;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    /**
     * 更新相应的数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id) {
        System.out.println("相应编号" + id);
        User updateUser = userDao.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user) {
        System.out.println(user);
        int i = userDao.editUser(user);
        String str = i > 0 ? "success" : "error";
        return str;
    }

    /**
     * 删除相应的用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        System.out.println(id);
        int i = userDao.deleteUser(id);
        String str = i > 0 ? "success" : "error";
        return str;
    }
}
