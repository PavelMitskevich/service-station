package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.service.CarService;
import by.mitskevich.servicestation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
//@RestController
//@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    private final UserService userService;

//    @GetMapping("/cars")
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    public List<CarDTO> getCars() {
//        return carService.getCars();
//    }

    @GetMapping("/cars")
    public String showSignUpForm(CarDTO carDTO) {
        return "redirect:/user/{id}/cars";
    }

    @GetMapping("/user/{id}/cars")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getCarsByUser(@PathVariable("id") Long id, Model model) {
//        User user = UserMapper.userDtoToUser(userService.getUserById(id));
//        model.addAttribute("user", user);
//        for (Car car : user.getCars()) {
//            model.addAttribute("car", car);
//        }
        List<CarDTO> cars = carService.getCarByUserId(id);
//        for (CarDTO carDTO : cars) {
            model.addAttribute("car", cars);
//        }
//        model.addAttribute("car", carService.getCarByUserId(id));
//        carService.getCars();
        return "cars";
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public CarDTO getCarById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/createCar")
    public String showCreateCar(CarDTO carDTO) {
        return "createCar";
    }

    @PostMapping("/createCar")
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER')")
    public String createCar(Model model,
                            @ModelAttribute("carDTO") CarDTO carDTO) {

        carDTO = carService.createCar(carDTO);
        model.addAttribute("car", carDTO);

        return "redirect:/user/" + carDTO.getUser().getId() + "/cars";
    }

    @PutMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public CarDTO updateCar(@PathVariable("id") Long id, @RequestBody CarDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }
}
