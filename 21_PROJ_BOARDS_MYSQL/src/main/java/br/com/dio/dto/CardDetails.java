package br.com.dio.dto;

import java.time.OffsetDateTime;

public record CardDetails(Long id,
                          String title,
                          String description,
                          Boolean blocked,
                          OffsetDateTime blockedAt,
                          String blockReason,
                          int blocksAmount,
                          Long columnId,
                          String columnName) {
}
