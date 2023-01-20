package com.scalar.design.lld.parkinglotv2.models;

import java.util.Date;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */

@Data
@SuperBuilder
public class BaseModel {
  private Long id;
  private Date createdAt;
  private Date updatedAt;
}
