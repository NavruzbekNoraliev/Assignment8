package edu.mum.cs.cs425.studentmgmt.service;

import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranscriptService {
    private final TranscriptRepository transcriptRepository;

    @Autowired
    public TranscriptService(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    public Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }

    public List<Transcript> getAllTranscripts() {
        return transcriptRepository.findAll();
    }

    public Transcript getTranscriptById(Long id) {
        return transcriptRepository.findById(id).orElse(null);
    }

    public void deleteTranscriptById(Long id) {
        transcriptRepository.deleteById(id);
    }
}

