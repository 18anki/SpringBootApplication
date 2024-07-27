package com.sample.test.dto;

import java.util.List;

public class StudentAndAddressDTO {
    Long id;
    String name;
    List<AddressDTO> addressDTOList;
    List<ParentDTO> parentDTOList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressDTO> getAddressDTOList() {
        return addressDTOList;
    }

    public void setAddressDTOList(List<AddressDTO> addressDTOList) {
        this.addressDTOList = addressDTOList;
    }

    public List<ParentDTO> getParentDTOList() {
        return parentDTOList;
    }

    public void setParentDTOList(List<ParentDTO> parentDTOList) {
        this.parentDTOList = parentDTOList;
    }
}
