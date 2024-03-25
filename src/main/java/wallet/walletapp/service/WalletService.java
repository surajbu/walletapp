package wallet.walletapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wallet.walletapp.entity.Wallet;
import wallet.walletapp.exception.WalletException;
import wallet.walletapp.repository.WalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    public Wallet getById(Long id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        } else {
            throw new WalletException("Wallet with ID " + id + " not found");
        }
    }

    public Wallet createOrUpdate(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public boolean delete(Long id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            walletRepository.delete(optionalWallet.get());
            return true;
        } else {
            throw new WalletException("Wallet with ID " + id + " not found");
        }
    }
}
