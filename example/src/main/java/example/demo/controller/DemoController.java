package example.demo.controller;

import example.demo.domain.*;
import example.demo.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class DemoController {

    private final ProfessorRepository professorRepository;

    public DemoController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Controller
    public class HomeController {

        @GetMapping("/home")
        public String home(Model model) {
            List<String> questions = List.of(
                    "1-a) 각 Table에 존재하는 Data를 확인하고 tuple의 총 갯수를 출력할 수 있어야 한다.",
                    "1-b) 특정 Student를 선택하여 해당 Student가 수강하는 Course 이름과 학점 및 시험 점수를 검색할 수 있어야 한다.",
                    "1-c) Student의 시험 점수에 대한 학점이 잘못 기재되어 있는 학생의 이름과 학번, 과목번호를" +
                            "확인 할 수 있어야 하며, 수정 요청에 대해 정상적인 학점으로 수정이 되어야 한다.",
                    "1-d) 과목별로 최고 점수와, 최저 점수를 흭득 한 학생의 정보를 확인 할 수 있어야 한다.",
                    "1-e) 학생별로 수강한 교과목의 총학점(sum of credits)과 시험점수의 평균을 확인할 수 있어야 한다.",
                    "1-f) 과목별로 전체 평균 점수와 학점별 학생 수를 확인할 수 있어야 한다.",
                    "1-g) 학과별 개설된 강좌의 수를 확인 할 수 있어야 한다.",
                    "1-h) 학과별, 학년별 총 학생 수를 확인할 수 있어야 한다.",
                    "2-a) 특정 작가를 선택하였을 경우 해당 작가가 작성한 도서의 제목, 해당 도서의 " +
                            "재고 수량을 확인할 수 있어야 한다.",
                    "2-b) 모든 출판사의 정보를 확인 할 수 있어야 하며, 특정 출판사를 선택 하였을 경우 해당 출판사에서 출판된" +
                            "도서의 제목과 가격, 재고량을 확인할 수 있어야 한다. 재고량이 없는 경우에는 해당 도서에 대해서 재고가" +
                            "없음을 알려주어야 한다.",
                    "2-c) 모든 고객의 정보를 확인 할 수 있어야 하며 특정 고객을 선택 하였을 경우, 해당 고객이 주문한 도서와 해당" +
                            "도서의 출판사, 저자의 정보를 출력 할 수 있어야 한다.",
                    "2-d) 새로운 도서가 등록 될 경우에는 저자와 출판사 창고별 재고량이 함께 등록 되어야 한다.",
                    "2-e) 전체 도서의 평균 가격 및 년도별 평균 가격을 산정할 수 있어야 한다.",
                    "2-f) 작가별 도서의 총 개수, 최고, 최저, 평균 가격을 확인 할 수 있어야 한다.",
                    "2-g) 재고가 특정 부수 이상 넘어가는 도서를 검색하고, 가격 할인을 할 수 있어야 한다."
            );

            // LinkedHashMap 사용해서 순서 유지
            Map<String, String> questionLinks = new LinkedHashMap<>();
            for (String q : questions) {
                questionLinks.put(q, "/result/" + q.substring(0, 3));
            }

            model.addAttribute("questionLinks", questionLinks);

            return "home";
        }

        @Autowired
        private StudentRepository studentRepository;
        @Autowired
        private ProfessorRepository professorRepository;
        @Autowired
        private CourseRepository courseRepository;
        @Autowired
        private EnrollRepository enrollRepository;
        @Autowired
        private LectureRepository lectureRepository;

        @GetMapping(value = "/result/1-a")
        public ModelAndView viewData1a() {
            ModelAndView modelAndView = new ModelAndView("1-a");

            List<StudentEntity> students = studentRepository.findAllByOrderBySnoAsc();
            List<ProfessorEntity> professors = professorRepository.findAllByOrderByPnoAsc();
            List<CourseEntity> courses = courseRepository.findAllByOrderByCnoAsc();
            List<EnrollEntity> enrolls = enrollRepository.findAllByOrderBySnoAscCnoAsc();
            List<LectureEntity> lectures = lectureRepository.findAllByOrderByCnoAscPnoAsc();

            long studentCount = studentRepository.countStudents();
            long professorCount = professorRepository.countProfessors();
            long courseCount = courseRepository.countCourses();
            long enrollCount = enrollRepository.countEnrolls();
            long lectureCount = lectureRepository.countLectures();

            modelAndView.addObject("students", students);
            modelAndView.addObject("professors", professors);
            modelAndView.addObject("courses", courses);
            modelAndView.addObject("enrolls", enrolls);
            modelAndView.addObject("lectures", lectures);

            modelAndView.addObject("studentCount", studentCount);
            modelAndView.addObject("professorCount", professorCount);
            modelAndView.addObject("courseCount", courseCount);
            modelAndView.addObject("enrollCount", enrollCount);
            modelAndView.addObject("lectureCount", lectureCount);

            return modelAndView;
        }

        @GetMapping(value = "/result/1-b")
        public ModelAndView viewData1b() {
            ModelAndView modelAndView = new ModelAndView("1-b");

            List<StudentEntity> students = studentRepository.findAllByOrderBySnoAsc();
            modelAndView.addObject("students", students);

            return modelAndView;
        }

        @GetMapping("/student/detail/{sname}")
        public ModelAndView studentGraded(@PathVariable String sname) {
            ModelAndView modelAndView = new ModelAndView("studentGrade");

            List<Object[]> studentGrade = studentRepository.findStudentCourseGradeData(sname);
            if (!studentGrade.isEmpty()) {
                modelAndView.addObject("studentGrade", studentGrade);
            }

            return modelAndView;
        }

        @GetMapping(value = "/result/1-c")
        public ModelAndView viewData1c() {
            ModelAndView modelAndView = new ModelAndView("1-c");

            List<Object[]> wrongGrade = studentRepository.findWrongGradeData();
            modelAndView.addObject("wrongGrade", wrongGrade);

            return modelAndView;
        }

        @Autowired
        private EnrollService enrollService;

        @PostMapping("/result/1-c/fix")
        public String updateEnrollGrade(@RequestParam("sno") int sno,
                                    @RequestParam("cno") String cno) {
            enrollService.updateEnrollGrade(sno, cno);
            return "redirect:/result/1-c";
        }

        @GetMapping(value = "/result/1-d")
        public ModelAndView viewData1d() {
            ModelAndView modelAndView = new ModelAndView("1-d");

            List<Object[]> MinMaxScore = studentRepository.findMinMaxScoreData();
            modelAndView.addObject("MinMaxScore", MinMaxScore);

            return modelAndView;
        }

        @GetMapping(value = "/result/1-e")
        public ModelAndView viewData1e() {
            ModelAndView modelAndView = new ModelAndView("1-e");

            List<Object[]> sumCredit = studentRepository.findSumStudentData();
            modelAndView.addObject("sumCredit", sumCredit);

            return modelAndView;
        }

        @GetMapping(value = "/result/1-f")
        public ModelAndView viewData1f() {
            ModelAndView modelAndView = new ModelAndView("1-f");

            List<Object[]> courseAvgExamGrade = enrollRepository.courseAvgExamGradeData();
            modelAndView.addObject("courseAvgExamGrade", courseAvgExamGrade);

            return modelAndView;
        }

        @GetMapping(value = "/result/1-g")
        public ModelAndView viewData1g() {
            ModelAndView modelAndView = new ModelAndView("1-g");

            List<Object[]> lectureCount = lectureRepository.lectureCountData();
            modelAndView.addObject("lectureCount", lectureCount);

            return modelAndView;
        }

        @GetMapping(value = "/result/1-h")
        public ModelAndView viewData1h() {
            ModelAndView modelAndView = new ModelAndView("1-h");

            List<Object[]> sumStudent = studentRepository.sumStudentData();
            modelAndView.addObject("sumStudent", sumStudent);

            return modelAndView;
        }

        @Autowired
        private BookRepository bookRepository;
        @Autowired
        private Written_byRepository written_byRepository;
        @Autowired
        private PublisherRepository publisherRepository;
        @Autowired
        private CustomerRepository customerRepository;
        @Autowired
        private StocksRepository stocksRepository;
        @Autowired
        private Published_byRepository published_byRepository;

        @GetMapping(value = "/result/2-a")
        public ModelAndView viewData2a() {
            ModelAndView modelAndView = new ModelAndView("2-a");

            List<String> writerName = written_byRepository.findWriterNames();
            modelAndView.addObject("writerName", writerName);

            return modelAndView;
        }

        @GetMapping("/writerName/detail/{name}")
        public ModelAndView writerBook(@PathVariable String name) {
            ModelAndView modelAndView = new ModelAndView("writerBook");

            modelAndView.addObject("name", name);

            List<Object[]> writeBook = bookRepository.findWriteBookData(name);
            if (!writeBook.isEmpty()) {
                modelAndView.addObject("writeBook", writeBook);
            }

            return modelAndView;
        }

        @GetMapping(value = "/result/2-b")
        public ModelAndView viewData2b() {
            ModelAndView modelAndView = new ModelAndView("2-b");

            List<Object[]> publisher = publisherRepository.findPublisher();
            modelAndView.addObject("publisher", publisher);

            return modelAndView;
        }

        @GetMapping("/publisherBook/detail/{name}")
        public ModelAndView publisherBook(@PathVariable String name) {
            ModelAndView modelAndView = new ModelAndView("publisherBook");

            modelAndView.addObject("name", name);

            List<Object[]> publisherBook = bookRepository.findPublisherBookData(name);
            if (!publisherBook.isEmpty()) {
                modelAndView.addObject("publisherBook", publisherBook);
            }

            return modelAndView;
        }

        @GetMapping(value = "/result/2-c")
        public ModelAndView viewData2c() {
            ModelAndView modelAndView = new ModelAndView("2-c");

            List<Object[]> customers = customerRepository.findCustomer();
            modelAndView.addObject("customers", customers);

            return modelAndView;
        }

        @GetMapping("/customerBook/detail/{email}")
        public ModelAndView customerBook(@PathVariable String email) {
            ModelAndView modelAndView = new ModelAndView("customerBook");

            modelAndView.addObject("email", email);

            List<Object[]> customerBook = customerRepository.findCustomerBookData(email);
            if (!customerBook.isEmpty()) {
                modelAndView.addObject("customerBook", customerBook);
            }

            return modelAndView;
        }

        @GetMapping(value = "/result/2-d")
        public ModelAndView viewData2d() {
            ModelAndView modelAndView = new ModelAndView("2-d");

            return modelAndView;
        }

        @Autowired
        BookService bookService;

        @PostMapping(value = "/insert/post")
        public ModelAndView insertPost(@RequestParam("isbn") int isbn,
                                       @RequestParam("title") String title,
                                       @RequestParam("year") int year,
                                       @RequestParam("price") int price,
                                       @RequestParam("stocks_code") String stocksCode,
                                       @RequestParam("stocks_num") int stocksNum,
                                       @RequestParam("writter") String writer,
                                       @RequestParam("publisher") String publisher) {
            ModelAndView modelAndView = new ModelAndView("insert2confirm");

            // 서비스 호출로 로직 위임
            bookService.insertBookAndRelated(isbn, title, year, price,
                    stocksCode, stocksNum,
                    writer, publisher);

            modelAndView.addObject("isbn", isbn);
            modelAndView.addObject("title", title);
            modelAndView.addObject("year", year);
            modelAndView.addObject("price", price);
            modelAndView.addObject("stocksCode", stocksCode);
            modelAndView.addObject("stocksNum", stocksNum);
            modelAndView.addObject("writer", writer);
            modelAndView.addObject("publisher", publisher);

            return modelAndView;
        }

        @GetMapping(value = "/result/2-e")
        public ModelAndView viewData2e() {
            ModelAndView modelAndView = new ModelAndView("2-e");

            float allBookPriceAvg = bookRepository.findAllBookPriceAvg();
            modelAndView.addObject("allBookPriceAvg", allBookPriceAvg);

            List<Object[]> yearBookPriceAvg = bookRepository.findYearBookPriceAvg();
            modelAndView.addObject("yearBookPriceAvg", yearBookPriceAvg);

            return modelAndView;
        }

        @GetMapping(value = "/result/2-f")
        public ModelAndView viewData2f() {
            ModelAndView modelAndView = new ModelAndView("2-f");

            List<Object[]> writterBookData = bookRepository.findWritterBookData();
            modelAndView.addObject("writterBookData", writterBookData);

            return modelAndView;
        }

        @GetMapping(value = "/result/2-g")
        public ModelAndView viewData2g(@RequestParam(name = "n", required = false) Integer n) {
            ModelAndView modelAndView = new ModelAndView("2-g");

            int n2 = (n == null) ? Integer.MAX_VALUE : n;

            List<Object[]> books = bookRepository.findManyNumBook(n2);
            modelAndView.addObject("books", books);
            modelAndView.addObject("n", n2);

            return modelAndView;
        }

        @PostMapping(value = "/result/2-g/discount")
        @Transactional
        public String applyDiscount(@RequestParam(name = "n") Integer n) {
            int n2 = (n == null) ? Integer.MAX_VALUE : n;

            bookRepository.updateBook(n2);

            // 할인 적용 후 다시 GET 요청으로 redirect
            return "redirect:/result/2-g?n=" + n2;
        }

    }
}
