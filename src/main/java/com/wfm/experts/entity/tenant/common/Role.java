/*
 *
 *  * © 2024-2025 WFM EXPERTS INDIA PVT LTD. All rights reserved.
 *  *
 *  * This software, including all associated files, documentation, and related materials,
 *  * is the proprietary property of WFM EXPERTS INDIA PVT LTD. Unauthorized copying,
 *  * distribution, modification, or any form of use beyond the granted permissions
 *  * without prior written consent is strictly prohibited.
 *  *
 *  * DISCLAIMER:
 *  * This software is provided "as is," without warranty of any kind, express or implied,
 *  * including but not limited to the warranties of merchantability, fitness for a particular
 *  * purpose, and non-infringement.
 *  *
 *  * For inquiries, contact legal@wfmexperts.com.
 *
 */

package com.wfm.experts.entity.tenant.common;

import org.springframework.security.core.GrantedAuthority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority { // ✅ Implement GrantedAuthority

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName; // ✅ Required for Spring Security
    }
}
