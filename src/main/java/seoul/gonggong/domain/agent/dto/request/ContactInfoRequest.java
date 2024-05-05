package seoul.gonggong.domain.agent.dto.request;

import seoul.gonggong.domain.agent.domain.ContactInfo;

public record ContactInfoRequest(
        String area,
        String businessName,
        String phoneNumber,
        String address
) {
    public static ContactInfo toContactInfo(String area, String businessName, String phoneNumber, String address) {
        return ContactInfo.builder()
                .area(area)
                .businessName(businessName)
                .phoneNumber(phoneNumber)
                .address(address)
                .build();
    }
}
