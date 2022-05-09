package org.openvasp.core.model.vasp;

import org.openvasp.core.model.ivms101.Person;
import org.springframework.stereotype.Service;

@Service
public class KnowYourCustomer {
    public boolean checkCustomer(Person person) {
        return true;
    }

    public boolean checkAddress(String address) {
        return true;
    }

}
