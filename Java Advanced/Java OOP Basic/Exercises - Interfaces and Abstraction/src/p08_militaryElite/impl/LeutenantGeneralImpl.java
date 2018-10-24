package p08_militaryElite.impl;

import p08_militaryElite.contracts.LeutenantGeneral;
import p08_militaryElite.contracts.Private;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {

    private List<Private> privateList;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary, List<Private> privates) {
        super(id, firstName, lastName, salary);
        this.privateList = privates;
    }

    @Override
    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privateList);
    }

    @Override
    public String toString() {
        StringBuilder leutenantGeneral = new StringBuilder(super.toString());
        leutenantGeneral
                .append(System.lineSeparator())
                .append("Privates:");

        List<Private> sortedPrvates =
                this.getPrivates()
                        .stream()
                        .sorted(Comparator.comparing(Private::getId, Comparator.reverseOrder()))
                        .collect(Collectors.toList());

        for (Private privateSoldiers : sortedPrvates) {
            leutenantGeneral
                    .append(System.lineSeparator())
                    .append(String.format("  %s", privateSoldiers.toString()));
        }

        return leutenantGeneral.toString();
    }
}
