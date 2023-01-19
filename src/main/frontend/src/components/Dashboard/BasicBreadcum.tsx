import Typography from "@mui/material/Typography";
import Breadcrumbs from "@mui/material/Breadcrumbs";
import { Link } from "react-router-dom";
import styled from "@emotion/styled";

type Breads = {
  text: string;
  url: string;
};

interface BasicBreadcumProps {
  breads: Breads[];
}

const BreadCumsContainer = styled.div`
  margin-bottom: 1em;
`;

const BasicBreadcum = ({ breads }: BasicBreadcumProps) => {
  return (
    <BreadCumsContainer role="presentation">
      <Breadcrumbs aria-label="breadcrumb">
        {breads.map((bread, i, { length }) => {
          if (i + 1 === length) {
            return <Typography key={i} color="text.primary">{bread.text}</Typography>;
          } else {
            return (
              <Link key={i}
                color="inherit"
                to={bread.url}
                style={{ textDecoration: "none" }}
              >
                {bread.text}
              </Link>
            );
          }
        })}
      </Breadcrumbs>
    </BreadCumsContainer>
  );
};

export default BasicBreadcum;
