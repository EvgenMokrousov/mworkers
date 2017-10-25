package ru.moneta.mes.tst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.moneta.mes.tst.model.Tabel;
import ru.moneta.mes.tst.model.Worker;
import ru.moneta.mes.tst.service.TabelService;
import ru.moneta.mes.tst.service.WorkerService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/db_editor" )
public class DBEditorController {
    private WorkerService workerService;
    private TabelService tabelService;

    @Inject //@Autowired
    public DBEditorController(WorkerService workerService, TabelService tabelService) {
        this.workerService = workerService;
        this.tabelService = tabelService;
    }

    @ModelAttribute( "worker" )
    public Worker setWorkerToModel() {
        return new Worker();
    }

    @ModelAttribute( "tabel" )
    public Tabel setTabelToModel() {
        return new Tabel();
    }

    private String[] DayTypes = {"Я","В","К","Б","От"};
    @ModelAttribute( "dayTypes" )
    public String[] setDayTypesToModel() { return DayTypes; }

    @RequestMapping( method = RequestMethod.GET )
    public String getWorkers( Model model ) {
        System.out.println( "1: GET" );
        model.addAttribute( "workerList", this.workerService.listWorker() ); // получаем workerList
        return "db_editor";
    }

    @RequestMapping( /*value = "/worker/add", */method = RequestMethod.POST )
    public String addWorkerFromForm( @Valid Worker worker, BindingResult bindingResult ) {
        System.out.println( "2: add: " );
        if ( bindingResult.hasErrors() ) { return "db_editor"; }
        workerService.addWorker(worker);
        return "redirect:/db_editor";
    }

    @RequestMapping( "/worker/delete/{workerId}" )
    public String delWorker( @PathVariable( "workerId" ) Long workerId ) {
        System.out.print( "3: delete: " );
        System.out.println( workerId );
        workerService.deleteWorker(workerId);
        return "redirect:/db_editor";
    }

    @RequestMapping( value=( "/worker/edit/{workerId}" ), method = RequestMethod.GET )
    public String editWorker( @PathVariable("workerId") Long workerId, Model model ) {
        System.out.print( "4: edit GET: " );
        System.out.println( workerId );

        Worker worker = workerService.getWorkerById( workerId );
        model.addAttribute( worker );
        model.addAttribute( "workerList", this.workerService.listWorker() ); // получаем workerList
        model.addAttribute( "tabelList", this.tabelService.getTabelForWorker( worker ) );
        return "db_editor";
    }

    @RequestMapping( value=("/worker/edit/{workerId}"), method = RequestMethod.POST )
    public String saveWorker( Worker worker ) {
        System.out.print("5: save POST: ");
        System.out.println(worker.getId());
        workerService.updateWorker( worker );
        return "redirect:/db_editor";
    }

    @RequestMapping( value = "/tabel/add/{workerId}", method = RequestMethod.POST )
    public String addOneDayForTabel ( /*@Valid */Tabel tabel
        , @PathVariable("workerId") Long workerId ) {
        System.out.println("7: Add after edit");
        System.out.println("date = " + tabel.getD() + ", dtype = " + tabel.getD_type());

        tabel.setWorker( workerService.getWorkerById( workerId ) );
        tabelService.addTabel( tabel );
        return "redirect:/db_editor";
    }

    @RequestMapping(value=("/worker/edit/{workerId}"), method = RequestMethod.POST, params = "dtype_s")
    public String saveWorkersTabel(
              @PathVariable("workerId") Long workerId
            , @RequestParam("dtype_s") List<String> aDtype_s
            , @RequestParam("id") List<Long> aId ) {

        System.out.print("6: save DType: ");
        /*System.out.print( workerId );
        System.out.println(aDtype_s);
        */
        Tabel tabel;
        Long l;
        String newDType;
        Object o;

        for ( int i = 0; i < aId.size(); i++ ) {
            o = aId.get(i);
            l = Long.parseLong(o.toString());
            tabel = tabelService.getTabelById(l);

            newDType = aDtype_s.get(i);

            if ( !newDType.equals(tabel.getD_type()) ) {
                /*System.out.print( l );
                System.out.print( tabel.getD_type() );
                System.out.println( newDType );
                */
                tabel.setD_type( newDType );
                tabelService.updateTabel( tabel );
            }
        }

        return "redirect:/db_editor";
    }

    @RequestMapping ( "worker/edit/db_editor/worker/{operation}/{workerId}" )
    public String nothingMethod (
            @PathVariable( "workerId" ) Long workerId
            , @PathVariable( "operation" ) String op ) {
        System.out.println( "nothing" );
        System.out.print( op );
        System.out.println( workerId );
        return "redirect:/db_editor";
    }
}