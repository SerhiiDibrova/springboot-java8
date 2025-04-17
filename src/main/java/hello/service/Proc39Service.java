

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hello.repository.Table19Repository;

@Service
public class Proc39Service {

    @Autowired
    private Table19Repository table19Repository;

    @Autowired
    private RestTemplate restTemplate;

    public void createRecord(Integer inputParam) {
        if (inputParam != null) {
            try {
                table19Repository.insertRecord(inputParam);
            } catch (Exception e) {
                // handle exception
            }
        } else {
            // handle null input
        }
    }

    public String getName(Integer inputParam) {
        if (inputParam != null) {
            try {
                String result = restTemplate.getForObject("http://localhost/dbo/func_9/{input}", String.class, inputParam);
                if (result != null) {
                    return result;
                } else {
                    // handle null result
                }
            } catch (Exception e) {
                // handle exception
            }
        } else {
            // handle null input
        }
        return null;
    }
}