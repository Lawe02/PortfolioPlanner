package org.example.stockapi.Dto.resp;

import java.util.List;

public record UserPlansResponseDto(List<PlanResponseDto> plans) {
}
