package com.dev.expensetrackerapi.service;

import com.dev.expensetrackerapi.dto.ExpenseDto;
import com.dev.expensetrackerapi.exception.ExpenseNotFoundException;
import com.dev.expensetrackerapi.model.Expense;
import com.dev.expensetrackerapi.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public String addExpense(ExpenseDto expenseDto) {
        Expense expense = mapFromDto(expenseDto);
        return expenseRepository.insert(expense).getId();
    }

    public ExpenseDto getExpense(String name){

        Expense expense = expenseRepository.findByName(name).orElseThrow(() -> new
                ExpenseNotFoundException(String.format("Cannot Find Expense by Name - %s", name)));;
        return mapToDto(expense);

    }

    public List<ExpenseDto> getAllExpenses(){

        return expenseRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public void updateExpense(ExpenseDto expenseDto) {
        Expense savedExpense =
                expenseRepository.findById(expenseDto.getId())
                        .orElseThrow(() -> new
                                ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("Cannot Find Expense by ID %s",
                                expenseDto.getId())));
        savedExpense.setExpenseName(expenseDto.getExpenseName());

        savedExpense.setExpenseCategory(expenseDto.getExpenseCategory());

        savedExpense.setExpenseAmount(expenseDto.getExpenseAmount());

        expenseRepository.save(savedExpense);
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }

    private ExpenseDto mapToDto(Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .expenseName(expense.getExpenseName())
                .expenseCategory(expense.getExpenseCategory())
                .expenseAmount(expense.getExpenseAmount())
                .build();
    }

    private Expense mapFromDto(ExpenseDto expense) {
        return Expense.builder()
                .expenseName(expense.getExpenseName())
                .expenseCategory(expense.getExpenseCategory())
                .expenseAmount(expense.getExpenseAmount())
                .build();
    }

}