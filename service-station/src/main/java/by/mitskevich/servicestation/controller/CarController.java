package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.service.CarService;
import by.mitskevich.servicestation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping()
public class CarController {

    private final CarService carService;

    private final UserService userService;

//    @GetMapping("/cars")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    public List<CarDTO> getCars() {
//        return carService.getCars();
//    }

    @GetMapping("/cars")
    public String showSignUpForm(CarDTO carDTO) {
        return "redirect:/user/{id}/cars";
    }

    @GetMapping("/users/{id}/cars")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getCarsByUser(@PathVariable("id") Long id, Model model) {
        List<CarDTO> cars = carService.getCarByUserId(id);
        model.addAttribute("cars", cars);
        return "pages/cars";
    }

    @GetMapping("/cars/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public CarDTO getCarById(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/cars/createCar")
    public String showCreateCar(CarDTO carDTO) {
        return "pages/createCar";
    }

    @PostMapping("/cars/createCar")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER')")
    public String createCar(Model model,
                            @ModelAttribute("carDTO") CarDTO carDTO) {

        carDTO = carService.createCar(carDTO);
        model.addAttribute("car", carDTO);

        return "redirect:/users/" + carDTO.getUser().getId() + "/cars";
    }

    @PutMapping("/cars/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public CarDTO updateCar(@PathVariable("id") Long id, @RequestBody CarDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @DeleteMapping("/cars/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }
}
