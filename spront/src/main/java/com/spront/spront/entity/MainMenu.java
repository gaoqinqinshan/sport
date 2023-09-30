package com.spront.spront.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainMenu {
    private int id;
    private String title;
    private String path;
    List<SubMenu> slist;
}
