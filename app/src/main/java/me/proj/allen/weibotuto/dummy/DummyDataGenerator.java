package me.proj.allen.weibotuto.dummy;

import me.proj.allen.weibotuto.R;
import me.proj.allen.weibotuto.dummy.pojo.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allen on 2018/2/22.
 */
public class DummyDataGenerator {
    private List<Course> courses;

    public DummyDataGenerator() {
        Course course_01 = new Course(0, 0, "Chinese New Year Make Up, meet BF's parents", R.drawable.makeup_01);
        Course course_02 = new Course(1, 0, "Novice's misunderstanding when hanging out with BF", R.drawable.makeup_02);
        Course course_03 = new Course(2, 0, "Raise ur dream girl's eyebrow~", R.drawable.makeup_03);
        Course course_04 = new Course(3, 0, "OTAKU girl -> enchanting exotic lass", R.drawable.makeup_04);
        Course course_05 = new Course(4, 0, "School girl first time fashion tryout", R.drawable.makeup_05);

        courses = new ArrayList<>();
        courses.add(course_01);
        courses.add(course_02);
        courses.add(course_03);
        courses.add(course_04);
        courses.add(course_05);
    }

    public List<Course> getCourses() {
        return courses;
    }
}
