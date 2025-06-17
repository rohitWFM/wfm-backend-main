package com.wfm.experts.entity.tenant.common.enums;

// Renamed to avoid conflict with your hr.recruitmentonboarding.enums.EmploymentType
public enum EmploymentType {
    PERMANENT,
    CONTRACT,
    INTERN,
    TEMPORARY,
    PART_TIME,
    FULL_TIME // Can overlap with Permanent/Contract but often used
}