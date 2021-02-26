package com.meubolso.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyDomain {

    String code;
    String codein;
    String name;
    String high;
    String low;
    String pctChange;
    Long timestamp;
}
