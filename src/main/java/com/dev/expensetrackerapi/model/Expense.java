package com.dev.expensetrackerapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("expense")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Expense {

@Id
private String id;
@Indexed(unique = true)
@Field("name")
private String expenseName;
@Field("category")
private ExpenseCategory expenseCategory;
@Field("amount")
private BigDecimal expenseAmount;



}
