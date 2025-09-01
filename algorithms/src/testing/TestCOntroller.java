/*
package testing;

@RestController
@RequestMapping("/app1")
public class TestController {

    @Autowired
    EMployeeService eMployeeService;

    @PostMapping("/employee/{id}")
    public void updateEmployee(@RequestBody @Valid EmployeeUpdate request, @RequestParam("id") String id){

        eMployeeService.updateEMployee(request, id);
        return ResponseEntity.okHttpStatus();

    }

}

class EMployeeService{
    public void updateEMployee(EmployeeUpdate request, String id){

    }
}

@ControllerAdvice
class GlobalExceptionHandling{

    @
}*/
