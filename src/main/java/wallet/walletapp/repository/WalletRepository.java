package wallet.walletapp.repository;

import wallet.walletapp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long>{

}
