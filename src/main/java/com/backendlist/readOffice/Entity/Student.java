package com.backendlist.readOffice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kj
 * @date 2023/4/27
 * @apiNote
 */

@Data

public class Student implements Serializable {
    Integer id;
    Integer StudentId;
    String name;
    String classes;
    String school;
}
