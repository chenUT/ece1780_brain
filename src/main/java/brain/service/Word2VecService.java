package brain.service;

import brain.models.QAText;
import org.apache.commons.io.Charsets;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by chen on 3/20/17.
 */
@Service
public class Word2VecService {

    private Word2Vec word2Vec;

    @Autowired
    QATextService qaTextService;

    @PostConstruct
    public void train() throws IOException {
        List<QAText> qaTexts = qaTextService.getQaTexts();
        System.out.println("training...");

        StringBuilder fullTextBuilder = new StringBuilder();
        qaTexts.forEach( qaText -> {
            fullTextBuilder.append(qaText.getQuestion().toLowerCase()+ "\n" + qaText.getAnswer().toLowerCase()+ "\n");
        });
        String fullText = fullTextBuilder.toString();

        System.out.println(fullText);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(fullText.getBytes(Charsets.UTF_8)));
        bufferedInputStream.mark(bufferedInputStream.available()+1);
        SentenceIterator iter = new BasicLineIterator(bufferedInputStream);
        TokenizerFactory t = new DefaultTokenizerFactory();
        t.setTokenPreProcessor(new CommonPreprocessor());

        int freq = 1;
        freq = fullText.length()/15000;
        if (freq == 0) {
            freq = 1;
        }
        System.out.println("Text length: "+fullText.length());
        System.out.println("freq : "+freq);

        // train the word to vev model with default sentences
        Word2Vec vec = new Word2Vec.Builder()
            .minWordFrequency(freq)
            .iterations(1)
            .layerSize(40)
            .seed(42)
            .windowSize(3)
            .iterate(iter)
            .tokenizerFactory(t)
            .build();

        vec.fit();

        this.word2Vec = vec;
    }

    public Word2Vec getWord2Vec() {
        return this.word2Vec;
    }
}
