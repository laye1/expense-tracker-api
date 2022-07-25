package com.dev.expensetrackerapi.controller;



/*
@WebMvcTest(controllers = ExpenseController.class)
public class ExpenseControllerTest {

    @MockBean
    private ExpenseService expenseService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should Create Expense")
    public void shouldCreateExpense() throws Exception {
        ExpenseDto expenseDto = ExpenseDto.builder()
                .expenseCategory(ExpenseCategory.ENTERTAINMENT)
                .expenseName("Movies")
                .expenseAmount(BigDecimal.TEN)
                .build();


        Mockito.when(expenseService.addExpense(expenseDto)).thenReturn("123");

        MvcResult mvcResult = mockMvc.perform((RequestBuilder) post("/api/expense"))

                .andExpect(MockMvcResultMatchers.status().isCreated())

                        .andExpect(MockMvcResultMatchers.header().exists(HttpHeaders.LOCATION))
                        .andReturn();


        assertTrue(mvcResult.getResponse().getHeaderValue(HttpHeaders.LOCATION).toString().contains("123"));

    }

}
*/