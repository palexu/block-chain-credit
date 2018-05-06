package top.palexu.blockchaincredit.credit.vo;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class CreditDataHistory {

    List<CreditDataHistoryItem> histories = new LinkedList<>();

}
