package ru.moneta.mes.tst.controller;

import ru.moneta.mes.tst.other.WorkerTabel;
import ru.moneta.mes.tst.service.WorkerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class StartController {
    private WorkerService workerService;
    private String f = "";
    private Date d;

    @Inject
    public StartController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping("/")
    public String home() {
        System.out.println("/");

        return "redirect:/index";
    }

    Iterator WorkerTabelResult;
    @RequestMapping("/index")
    public String getWorkers(Model model) {
        System.out.println("/index");
        System.out.print("f = ");
        System.out.println(f);
        String str;

        if (f.length() > 0) {
            List<WorkerTabel> workerTabels = new ArrayList<WorkerTabel>();
            WorkerTabelResult = this.workerService.selectWorker2(f, d).iterator();
            System.out.println("Фамилия: Тип дня:type");
            while (WorkerTabelResult.hasNext()) {
                Object[] row = (Object[]) WorkerTabelResult.next();
                str = (String) row[3];
                if ( str.equals( "Я" )) row[3] = "Явка["+row[3]+"]";
                if ( str.equals( "В" )) row[3] = "Выходной["+row[3]+"]";
                if ( str.equals( "К" )) row[3] = "Командировка["+row[3]+"]";
                if ( str.equals( "Б" )) row[3] = "Больничный["+row[3]+"]";
                if ( str.equals( "От" )) row[3] = "Отпуск["+row[3]+"]";

                workerTabels.add(new WorkerTabel((String) row[0], (String) row[1], (String) row[2], (String) row[3]));
            }
            model.addAttribute("workerList", workerTabels);

        }
        f = "";

        return "workers";
    }

    @RequestMapping(value=("/select"), method = RequestMethod.GET)
    public String selWorkers(@RequestParam("find") String find
                            , @RequestParam("date") String date) {

        f = find;
        SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            d = new Date( df.parse( date ).getTime() );
        } catch ( ParseException e ) {
            e.printStackTrace();
        }
        System.out.print("select_form:");
        System.out.print("find = " + find + " date = ");
        System.out.println(d);

        return "redirect:/index";
    }

}