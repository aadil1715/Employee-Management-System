package com.dalhousie.group14.Presentation.utilities;

import java.util.List;

public class TableFormatter {

  public static String formatAsTable(List<List<String>> tablerows) {
    try {
      int[] maxLengths = new int[tablerows.get(0).size()];

      for (List<String> row : tablerows) {
        for (int i = 0; i < row.size(); i++) {
          maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
        }
      }

      StringBuilder formatBuilder = new StringBuilder();
      for (int maxLength : maxLengths) {
        formatBuilder.append("%-").append(maxLength + 2).append("s");
      }
      String format = formatBuilder.toString();

      StringBuilder result = new StringBuilder();
      for (List<String> row : tablerows) {
        result.append(String.format(format, row.toArray(new String[0]))).append("\n");
      }
      return result.toString();
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      return null;
    }

  }
}
