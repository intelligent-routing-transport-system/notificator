package br.com.smartservice.notificator.notificator.dtos.internal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiBaseDto<T> {
    private boolean isError;
    private T data;

    public ApiBaseDto(T data) {
        this.data = data;
    }

    public ApiBaseDto(boolean isError, T data) {
        this.isError = isError;
        this.data = data;
    }
}
