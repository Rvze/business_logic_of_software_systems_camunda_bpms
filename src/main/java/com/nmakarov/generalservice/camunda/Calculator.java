package com.nmakarov.generalservice.camunda;

import com.nmakarov.generalservice.CalculatorEntity;
import com.nmakarov.generalservice.CalculatorJpaRepository;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator implements JavaDelegate {
    private final CalculatorJpaRepository jpaRepository;

    @Override
    public void execute(DelegateExecution execution) {
        Integer x = Integer.valueOf(String.valueOf(execution.getVariable("x")));
        Integer y = Integer.valueOf(String.valueOf(execution.getVariable("y")));
        char sign = execution.getVariable("sign").toString().charAt(0);
        int res = 0;
        if (sign == '+') {
            res = x + y;
        } else if (sign == '-') {
            res = x - y;
        } else if (sign == '*') {
            res = x * y;
        } else if (sign == '/') {
            res = x / y;
        }
        execution.setVariable("res", res);
        CalculatorEntity calculator = CalculatorEntity.builder()
                .x(x)
                .y(y)
                .res(res).build();
        jpaRepository.save(calculator);
    }
}
