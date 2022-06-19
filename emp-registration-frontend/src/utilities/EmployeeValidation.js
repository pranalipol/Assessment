import * as yup from "yup";

const schema = yup.object().shape({
  empname: yup.string().required().max(100),
  dateofjoining: yup.date().required().typeError("please enter valid date"),
  department_code: yup.string().required(),
  salary: yup.number().required().positive(),
});

export const validateEmployee = (employee) =>
  schema.validate(employee, { abortEarly: false });
