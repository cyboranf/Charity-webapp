package pl.project.charity.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.charity.domain.Donation;
import pl.project.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Donation findById(Long id) {
        return donationRepository.findFirstById(id);
    }

    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }

    public int quantityOfBags() {
        try {
            return donationRepository.quantityOfAllBags();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    public int quantityOfDonations() {
        try {
            return donationRepository.quantityOfAllDonations();
        } catch (NullPointerException exception) {
            return 0;
        }
    }

    public List<Donation> myDonations(Long id) {
        return donationRepository.myDonations(id);
    }

    public List<Donation> donationByInstitutionId(Long id) {
        return donationRepository.donationsByInstitutionId(id);
    }
}
