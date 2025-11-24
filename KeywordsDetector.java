public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations
        String[] keywords = { "synergy", "disrupt", "leverage", "Paradigm", "transform" };
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String str = sentences[i];
            
            // Convert to lowercase for case-insensitive comparison
            String lowerStr = str.toLowerCase();
            
            boolean isPresent = false;
            
            for (int h = 0; h < keywords.length; h++) {
                String key = keywords[h].toLowerCase(); // Lowercase the keyword too
                
                // FIXED: Changed < to <= so we don't miss a keyword at the very end
                for (int j = 0; j <= lowerStr.length() - key.length(); j++) {
                    
                    // FIXED: Changed charAt(i) to charAt(j)
                    if (lowerStr.charAt(j) == key.charAt(0)) {
                        
                        int count = 0;
                        for (int k = 0; k < key.length(); k++) {
                            // FIXED: Changed charAt(i + k) to charAt(j + k)
                            if (lowerStr.charAt(j + k) == key.charAt(k)) {
                                count++;
                            } else {
                                break; // Optimization: Stop matching if char doesn't match
                            }
                        }
                        
                        if (count == key.length()) {
                            isPresent = true;
                            break; // Break out of the string loop (j)
                        }
                    }
                }
                
                // If we found one keyword in this sentence, we don't need to check other keywords
                if (isPresent) {
                    break; 
                }
            }
            
            if (isPresent) {
                System.out.println(str);
            }
        }
    }
}