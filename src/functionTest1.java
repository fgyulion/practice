import java.util.function.Predicate;

class Person{
    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    String name;
    String sex;

    public void test2(){

        Person jack = new Person("jack","男");

        /** 新建一个判断是否为Boy的匿名子类对象，别忘了全部加泛型否则会报错 * */
        Predicate<Person> PredicateBody = a -> "男".equals(a.sex);

        if(PredicateBody.test(jack)){
            System.out.println(jack.name + "是男的！");
        }
    }
}