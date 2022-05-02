package org.openvasp.core.service;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.vasp.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class VaspService extends BaseService {

    public VaspService(EntityManager entityManager) {
        super(entityManager);
    }

    @Transactional
    public long addVaspAccount(VaspAccount account){
        try {
            VaspAccount vaspAccount = getVaspAccount(account.getLogin());
        } catch (NoResultException e) {
            account.setAccountNumber(Lnurl.getRandomHexString(34));
            persistAccount(account);
            return account.getId();
        }
        throw new RuntimeException("Account " + account.getLogin() + " already exists!");
    }

    @Transactional
    public VaspAccount updateAssetAddress(String login, String assetType, String assetAddress) {
        VaspAccount account = getVaspAccount(login);
        account.setAssetAddress(assetType, assetAddress);
        persistAccount(account);
        return account;
    }

    public VaspAccount getVaspAccount(String login) {
        VaspAccount account = entityManager.createQuery(
                String.format("select a from VaspAccount a where a.login = '%s'", login),
                VaspAccount.class).getSingleResult();
        return account;
    }
}
