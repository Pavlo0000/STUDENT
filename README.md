Класс Student описывает информацию о студенте.
В особенности стоит отметить такие поля как now_session и last_grades
. Last grades содержит список объектов Session, а now_session(предстоящая сессия, по окончании которой этот объект добавляется 
в список last_grades, при этом now_session присваивается ссылка на новый переданный в методе объект) содержит ссылку на экземпляр Session.
Session содержит поле список объектов Discipline(Предмет, содежит название и переменную перечисления Grades, которая может принимать значения 5, 4, 3, 2, зачет, незачет, не определено (те сессия еще не началась и оценка не выставлена)), с переменными этих классов можно взаимодействовать с помощью методов. У Student есть 2 конструктора: 1) для человека поступающего с начала, 2) для человека, который перешел на другое направление, или с другого вуза итд

В методе main создаётся список(группа) студентов одного направления, рандомно выставляется сессия и выводится информация(имена, фамилии содержатся в разных файлах, чтобы были рандомные ФИО(считывание из файла и Random)) 
