package com.spront.spront.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单实例化
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubMenu {
    private int id;
    private String title;
    private String path;
}
