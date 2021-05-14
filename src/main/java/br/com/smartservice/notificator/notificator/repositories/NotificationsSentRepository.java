package br.com.smartservice.notificator.notificator.repositories;

import br.com.smartservice.notificator.notificator.models.NotificationSent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsSentRepository extends JpaRepository<NotificationSent, Long> {
}
