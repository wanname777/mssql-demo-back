package com.example.mssqldemoback.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author vannmaureen
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Course对象", description = "")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String name;
    private Double teachingTime;
    private Double credit;
    private Integer isOpen;
    private Integer limitNumber;
    private Integer chooseNumber;
}
