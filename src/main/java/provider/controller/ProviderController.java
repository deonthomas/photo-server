package provider.controller;


import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.web.bind.annotation.RequestParam;
import provider.domain.Provider;
import provider.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import static Utils.StringUtils.isNullOrEmpty;

@RestController()
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/provider")
    public List<Provider> getAllProviders() {
        return providerService.findAll();
    }

    @RequestMapping("/provider/id")
    public Provider getProviderById(@RequestParam Long id) throws InvalidArgumentException {
        if (isNullOrEmpty(id.toString()) == false) {
            return providerService.fineOneServiceProvider(id);
        }
        throw new InvalidArgumentException(new String[]{"Id"});
    }
//
//    @RequestMapping("/provider/id")
//    public Provider getProviderByType(@RequestParam Long id) throws InvalidArgumentException {
//        if (isNullOrEmpty(id.toString()) == false) {
//            return providerService.fineOneServiceProvider(id);
//        }
//        throw new InvalidArgumentException(new String[]{"Id"});
//    }
}